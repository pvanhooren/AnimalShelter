import java.time.LocalDateTime;

public class Reservor {
    public String Name;
    public LocalDateTime ReservedAt;

    public Reservor(String name, LocalDateTime reservedAt)
    {
        this.Name = name;
        this.ReservedAt = reservedAt;
    }
}
