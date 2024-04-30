package br.com.woppi.challenge.domain;

import java.util.*;

public class Dev {
    private String name;
    private Set<Content> contentSubscribers = new LinkedHashSet<>();
    private Set<Content> contentsCompleted = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.contentSubscribers.addAll(bootcamp.getContents());
        bootcamp.getDevsRegistered().add(this);
    }

    public void finishStage() {
        Optional<Content> conteudo = this.contentSubscribers.stream().findFirst();
        if(conteudo.isPresent()) {
            this.contentsCompleted.add(conteudo.get());
            this.contentSubscribers.remove(conteudo.get());
        } else {
            System.err.println("Atenção! Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calculateTotalXp() {
        Iterator<Content> iterator = this.contentsCompleted.iterator();
        double sum = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calculateXp();
            sum += next;
        }
        return sum;


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Content> getContentSubscribers() {
        return contentSubscribers;
    }

    public void setContentSubscribers(Set<Content> contentSubscribers) {
        this.contentSubscribers = contentSubscribers;
    }

    public Set<Content> getContentsCompleted() {
        return contentsCompleted;
    }

    public void setContentsCompleted(Set<Content> contentsCompleted) {
        this.contentsCompleted = contentsCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) && Objects.equals(contentSubscribers, dev.contentSubscribers) && Objects.equals(contentsCompleted, dev.contentsCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contentSubscribers, contentsCompleted);
    }
}
