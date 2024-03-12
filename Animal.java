import java.util.List;

public abstract class Animal {
     // Whether the animal is alive or not.
     private boolean alive;
     // The animal's position.
     private Location location;
     // The field occupied.
     private Field field;

     public Animal(Field field, Location location)
     {
        alive = true;
        this.field = field;
        setLocation(location);
     }

     abstract public void act(List<Animal> newAnimals);

    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Check whether the animal is alive or not.
     * @return True if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }

    protected Field getField()
    {
        return field;
    }
}
