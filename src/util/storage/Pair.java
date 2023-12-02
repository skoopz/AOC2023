package util.storage;

public record Pair<T, V>(T first, V second) {

    public String toString() {

        return this.first + "" + this.second;

    }

}
