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
}
