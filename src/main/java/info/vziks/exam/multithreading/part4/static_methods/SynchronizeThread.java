package info.vziks.exam.multithreading.part4.static_methods;

public class SynchronizeThread extends Thread {
    private Resource resource;
    @Override
    public void run() {
        Resource.changeStaticInt();
    }

    public SynchronizeThread setResource(Resource resource) {
        this.resource = resource;
        return this;
    }

}
