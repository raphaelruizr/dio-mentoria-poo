package dio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import dio.dominio.Bootcamp;
import dio.dominio.Conteudo;
import dio.dominio.Curso;
import dio.dominio.Dev;
import dio.dominio.Mentoria;

public class Main {

	public static void main(String[] args) {
		Curso cursoJavaI = new Curso();
		cursoJavaI.setTitulo("Java Básico");
		cursoJavaI.setDescricao("Aprenda os conceitos básicos sobre Java.");
		cursoJavaI.setCargaHoraria(8);

		Curso cursoDotNet = new Curso();
		cursoDotNet.setTitulo(".NET");
		cursoDotNet.setDescricao("Aprenda os conceitos básicos sobre C#.");
		cursoDotNet.setCargaHoraria(8);

		Curso cursoJavaII = new Curso();
		cursoJavaII.setTitulo("Java Avançado");
		cursoJavaII.setDescricao("Aprenda os conceitos avançados sobre Java.");
		cursoJavaII.setCargaHoraria(8);

		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("Aprendendo Orientação a Objetos com Java");
		mentoria.setDescricao("Imersão sobre os pilares da Orientação a Objetos.");
		mentoria.setData(LocalDateTime.now());

		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("START JAVA");
		bootcamp.setInicio(LocalDate.now());
		bootcamp.setFim(bootcamp.getInicio().plusDays(45));// pego a data do inicio mais 45 dias
		List<Conteudo> conteudosBootcamp = Arrays.asList(cursoJavaI, cursoJavaII, mentoria);
		bootcamp.setCounteudos(conteudosBootcamp);

		Dev joshuan = new Dev();
		joshuan.setNome("Joshuan");

		Dev zezin = new Dev();
		zezin.setNome("Zezinho");

		joshuan.inscrever(cursoJavaI);
		joshuan.inscrever(bootcamp);
		joshuan.progredir();
		joshuan.progredir();

		zezin.inscrever(bootcamp);
		zezin.progredir();
		zezin.progredir();
		zezin.progredir();
		zezin.progredir();

		System.out.println(String.format("XP Joshuan: %.2f", joshuan.calcularTotalXp()));
		System.out.println(String.format("XP Zezin: %.2f", zezin.calcularTotalXp()));
	
		List<Dev> ranking = Arrays.asList(joshuan, zezin).stream()
									.sorted((dev1, dev2) -> Double.compare(dev2.calcularTotalXp(), dev1.calcularTotalXp()))
									.collect(Collectors.toList());
		
		for (Dev dev : ranking) {
			System.out.println(dev.getNome());
		}
	}

}
