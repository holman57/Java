import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Flower {
    public String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower {
    public String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    public String whatsYourName() {
        return "Lily";
    }
}

class Region {
    Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal extends Region {
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class AndhraPradesh extends Region {
    Lily yourNationalFlower() {
        return new Lily();
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        assert region != null;
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}