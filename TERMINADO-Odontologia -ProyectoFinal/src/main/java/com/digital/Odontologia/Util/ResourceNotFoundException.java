package com.digital.Odontologia.Util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ResourceNotFoundException extends RuntimeException{
    private final String resourseId;
    private final String resourse;
}
