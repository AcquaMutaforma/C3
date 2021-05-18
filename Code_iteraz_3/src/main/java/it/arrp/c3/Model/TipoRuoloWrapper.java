package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.TipoRuolo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ruolo")
public class TipoRuoloWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nomeRuolo")
    @Enumerated(EnumType.STRING)
    private TipoRuolo ruolo;

    public TipoRuoloWrapper() {
    }

    public TipoRuoloWrapper(TipoRuolo ruolo) {
        this.ruolo = ruolo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoRuolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(TipoRuolo ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoRuoloWrapper)) return false;
        TipoRuoloWrapper that = (TipoRuoloWrapper) o;
        return getRuolo() == that.getRuolo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRuolo());
    }
}
