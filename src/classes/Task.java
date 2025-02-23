package classes;

public class Task<I, D, S> {
    public I id;
    public D description;
    public S statName;

  public Task(I id, D description, S statName) {
    this.id = id;
    this.description = description;
    this.statName = statName;
        }

    public I getId() {
        return id;
    }

    public D getDescription() {
        return description;
    }

    public S getStatName() {
        return statName;
    }

    public void setId(I id) {
        this.id = id;
    }

    public void setDescription(D description) {
       this.description = description;
    }

    public void setStatName(S statName) {
            this.statName = statName;
    }
    @Override
    public String toString() {
      return id + "‖" + description + "‖" + statName;
    }
}