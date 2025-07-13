package HandsOn6;

public class Country {
    private String code;
    private String name;

    public Country() {
        System.out.println("Inside Country Constructor");
    }

    public String getCode() {
        System.out.println("getCode() called");
        return code;
    }

    public void setCode(String code) {
        System.out.println("setCode() called");
        this.code = code;
    }

    public String getName() {
        System.out.println("getName() called");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName() called");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
