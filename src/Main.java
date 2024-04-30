import br.com.woppi.challenge.domain.Bootcamp;
import br.com.woppi.challenge.domain.Course;
import br.com.woppi.challenge.domain.Dev;
import br.com.woppi.challenge.domain.Mentoring;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Course curso1 = new Course();
        curso1.setTitle("Curso Java");
        curso1.setDescription("Este curso aborda os fundamentos da linguagem Java, incluindo conceitos de programação orientada a objetos, estruturas de controle, arrays e muito mais.");
        curso1.setWorkload(12);

        Course curso2 = new Course();
        curso2.setTitle("Curso JavaScript");
        curso2.setDescription("Um curso introdutório sobre JavaScript, cobrindo desde os conceitos básicos até técnicas avançadas de manipulação do DOM e eventos.");
        curso2.setWorkload(5);

        Mentoring mentoria = new Mentoring();
        mentoria.setTitle("Mentoria de java");
        mentoria.setDescription("Esta mentoria oferece um ambiente prático para os participantes aprofundarem seus conhecimentos em Java.");
        mentoria.setDate(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Bootcamp Java Developer");
        bootcamp.setDescription("Abstraindo o domínio de Bootcamp Java");
        bootcamp.getContents().add(curso1);
        bootcamp.getContents().add(curso2);
        bootcamp.getContents().add(mentoria);

        Dev devFernanda = new Dev();
        devFernanda.setName("Fernanda");
        devFernanda.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Fernanda:" + devFernanda.getContentSubscribers());
        devFernanda.finishStage();
        devFernanda.finishStage();
        devFernanda.finishStage();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Fernanda:" + devFernanda.getContentSubscribers());
        System.out.println("Conteúdos Concluídos Fernanda:" + devFernanda.getContentsCompleted());
        System.out.println("XP:" + devFernanda.calculateTotalXp());

        System.out.println("---------------------");

        Dev devDiego = new Dev();
        devDiego.setName("Diego");
        devDiego.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Diego:" + devDiego.getContentSubscribers());
        devDiego.finishStage();
        devDiego.finishStage();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Diego:" + devDiego.getContentSubscribers());
        System.out.println("Conteúdos Concluidos Diego:" + devDiego.getContentsCompleted());
        System.out.println("XP:" + devDiego.calculateTotalXp());

        System.out.println("---------------------");

        Dev devRodrigo = new Dev();
        devRodrigo.setName("Rodrigo");
        devRodrigo.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Rodrigo:" + devRodrigo.getContentSubscribers());
        devRodrigo.finishStage();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Rodrigo:" + devRodrigo.getContentSubscribers());
        System.out.println("Conteúdos Concluidos Rodrigo:" + devRodrigo.getContentsCompleted());
        System.out.println("XP:" + devRodrigo.calculateTotalXp());

    }

}
