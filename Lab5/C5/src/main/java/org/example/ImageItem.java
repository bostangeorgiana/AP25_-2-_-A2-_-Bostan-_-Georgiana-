package org.example;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record ImageItem(String name, LocalDate date, List<String> tags, String path) {}


