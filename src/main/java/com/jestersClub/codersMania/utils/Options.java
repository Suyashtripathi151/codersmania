package com.jestersClub.codersMania.utils;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
@Embeddable
public class Options {

    private List<Option> allOptions;

    private Option correctOption;
}
