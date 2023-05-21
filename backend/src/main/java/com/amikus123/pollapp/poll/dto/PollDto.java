package com.amikus123.pollapp.poll.dto;

import lombok.Value;

import java.util.List;

public record PollDto(String title, List<PollOptionDto> pollOptions) {
}
