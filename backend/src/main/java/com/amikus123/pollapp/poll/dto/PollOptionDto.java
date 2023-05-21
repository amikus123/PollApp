package com.amikus123.pollapp.poll.dto;


import java.util.List;

public record PollOptionDto(String title, List<PollOptionChoiceDto> pollOptionChoices) {
}
