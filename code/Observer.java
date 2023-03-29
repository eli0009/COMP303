package code;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {

        FileSystem fileSystem = new FileSystem(10);
        FileSystemMonitor monitor = new FileSystemMonitor(fileSystem);

        fileSystem.setFiles(20);
        fileSystem.setFiles(30);

    }
}

interface FileSystemObserver {
    void update();
}

interface FileSystemObservable {
    void addObserver(FileSystemObserver observer);

    void removeObserver(FileSystemObserver observer);

    void notifyObservers();

    int getFiles();
}

class FileSystemMonitor implements FileSystemObserver {
    private FileSystemObservable fileSystem;

    public FileSystemMonitor(FileSystemObservable fileSystem) {
        this.fileSystem = fileSystem;
        this.fileSystem.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Number of files changed to: " + fileSystem.getFiles());
    }
}

class FileSystem implements FileSystemObservable {
    private int files;
    private List<FileSystemObserver> observers = new ArrayList<>();

    public FileSystem(int files) {
        this.files = files;
    }

    public int getFiles() {
        return files;
    }

    public void setFiles(int files) {
        this.files = files;
        notifyObservers();
    }

    @Override
    public void addObserver(FileSystemObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FileSystemObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (FileSystemObserver observer : observers) {
            observer.update();
        }
    }
}