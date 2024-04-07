package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Oppgave1Test {
    Oppgave1 oppgave1 = new Oppgave1();

    @Test
    void getOppgaveNavn() {
        assertEquals("Oppgave1", oppgave1.getOppgaveNavn());
    }
}