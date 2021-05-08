import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Scanner;

@Retention(value= RetentionPolicy.RUNTIME)
@interface SaveTo{
    String path();
}
@Retention(value=RetentionPolicy.RUNTIME)
@interface Saver{
    }
    @SaveTo(path="C:\\Users\\CoopMicro\\Desktop\\file.txt")
public class TextContainer {
    Scanner sc=new Scanner(System.in);
    private final String TEXT=sc.nextLine();

    @Saver
        public void save(String path){
        try(FileWriter writer = new FileWriter(path)){
            writer.write(TEXT);
            System.out.println("Сохранение успешно выполнено");
        } catch (IOException e){
            System.out.println("Ошибка сохранения:"+e.getMessage());
        }
    }
}
