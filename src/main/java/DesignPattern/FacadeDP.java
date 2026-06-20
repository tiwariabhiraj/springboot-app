package DesignPattern;
class TV {
    void on(){
        System.out.println("TV ON");
    }
}
class SoundSystem {
    void on(){
        System.out.println("Sound System ON");
    }
}
class DVDPlayer {
    void play(){
        System.out.println("DVD Playing");
    }
}
class HomeTheaterFacade {

    TV tv;
    SoundSystem sound;
    DVDPlayer dvd;

    HomeTheaterFacade(TV tv, SoundSystem sound, DVDPlayer dvd){
        this.tv = tv;
        this.sound = sound;
        this.dvd = dvd;
    }

    void watchMovie(){
        tv.on();
        sound.on();
        dvd.play();
    }
}
public class FacadeDP {
    public static void start() {

        TV tv = new TV();
        SoundSystem sound = new SoundSystem();
        DVDPlayer dvd = new DVDPlayer();

        HomeTheaterFacade home = new HomeTheaterFacade(tv, sound, dvd);

        home.watchMovie();
    }
}