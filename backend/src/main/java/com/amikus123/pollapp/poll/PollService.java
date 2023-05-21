package com.amikus123.pollapp.poll;

import com.amikus123.pollapp.entities.Poll;
import com.amikus123.pollapp.entities.PollOption;
import com.amikus123.pollapp.entities.PollOptionChoice;
import com.amikus123.pollapp.poll.dto.PollDto;
import com.amikus123.pollapp.poll.dto.PollOptionChoiceDto;
import com.amikus123.pollapp.poll.dto.PollOptionDto;
import com.amikus123.pollapp.repositories.PollOptionChoiceRepository;
import com.amikus123.pollapp.repositories.PollOptionRepository;
import com.amikus123.pollapp.repositories.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepository pollRepository;
    private final PollOptionRepository pollOptionRepository;
    private final PollOptionChoiceRepository pollOptionChoiceRepository;

    public List<Poll> getPolls() {
        return pollRepository.findAll();
    }
    public Optional<Poll> getPollById(Integer pollId) {
        return pollRepository.findById(pollId);
    }


    public Poll createPoll(PollDto pollDto) {
        Poll poll = pollRepository.save(Poll.builder().title(pollDto.title()).build());
        for (PollOptionDto pollOptionDto : pollDto.pollOptions()) {
            PollOption pollOption = pollOptionRepository.save(PollOption.builder()
                    .title(pollOptionDto.title()).poll(poll).build());
            for (PollOptionChoiceDto pollOptionChoiceDto : pollOptionDto.pollOptionChoices()) {
                PollOptionChoice pollOptionChoice = pollOptionChoiceRepository.save(
                        PollOptionChoice.builder().value(pollOptionChoiceDto.value()).pollOption(pollOption)
                                .text(pollOptionChoiceDto.text()).build());
            }
        }
        return poll;
    }

}
