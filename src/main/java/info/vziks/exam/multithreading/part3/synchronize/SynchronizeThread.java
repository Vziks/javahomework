package info.vziks.exam.multithreading.part3.synchronize;

public class SynchronizeThread extends Thread {
    private Resource resource;
    @Override
    public void run() {
        resource.increaseValue();
    }

    public SynchronizeThread setResource(Resource resource) {
        this.resource = resource;
        return this;
    }

}
