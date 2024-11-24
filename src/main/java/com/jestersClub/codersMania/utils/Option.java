package com.jestersClub.codersMania.utils;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.util.Map;

@Data

public class Option {

    private Map<Integer, OptionDetails> option;
}
