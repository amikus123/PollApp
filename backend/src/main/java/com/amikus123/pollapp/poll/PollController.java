package com.amikus123.pollapp.poll;

import com.amikus123.pollapp.auth.dto.AuthenticationRequest;
import com.amikus123.pollapp.auth.dto.RegisterRequest;
import com.amikus123.pollapp.entities.Poll;
import com.amikus123.pollapp.poll.dto.PollDto;
import com.amikus123.pollapp.utils.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/poll")
public class PollController {
    private final PollService pollService;
    @GetMapping("aa")
    public ResponseEntity getPolls(
    ) {
        try {
            return ResponseEntity.ok(pollService.getPolls());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getPollById(
          @PathVariable("id") int pollId
    ) {
        try {
            Optional<Poll> poll = pollService.getPollById(pollId);
            if(poll.isPresent()){
            return ResponseEntity.ok(poll);
            }else{
                return new ResponseEntity<String>("Not offer with this id", HttpStatus.NOT_FOUND);
            }

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
    @PostMapping("")
    public ResponseEntity createPoll(
            @RequestBody PollDto request
    ) {
        try {
            Poll poll =  pollService.createPoll(request);
            return ResponseEntity.ok(poll);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST));
        }
    }
}
