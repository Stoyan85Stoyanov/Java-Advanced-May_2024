package _006_DefiningClasses._02_Exercise._07_Google;

public class Pokemon {

    private String pokemonName;
    private String pokemonType;


    public Pokemon(String pokemonName, String pokemonType) {
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }
    @Override
    public String toString () {
        return pokemonName + " " + pokemonType;
    }
}