package it.unicam.morpheus.sogniario.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

enum NominationStatus{PENDENTE, ACCEPTED, REJECTED}

@Document(collection = "nomination")
@NoArgsConstructor
public class Nomination {

    @Id @Getter @Setter @NonNull
    private String email;

    @Getter @Setter @NonNull
    private String name;

    @Getter @Setter @NonNull
    private String motivazione;

    @Getter @Setter @NonNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime data;

    @Getter @Setter @NonNull
    private NominationStatus status;

    public Nomination(@NonNull String name, String motivazione){
        if(motivazione.isBlank()) throw new IllegalArgumentException("The motivazione is blank");
        this.motivazione = motivazione;
        if(name.isBlank()) throw new IllegalArgumentException("The name is blank");
        this.name = name;
        this.data = LocalDateTime.now();
        this.status = NominationStatus.PENDENTE;
    }
}
