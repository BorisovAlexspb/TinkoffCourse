package edu.hw6.Task6;

public record Port(Protocol protocol, int port, String app) {
    enum Protocol {
        TCP, UDP
    }
}
