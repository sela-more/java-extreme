package exchanger;

public class Tester implements Runnable {

	Exchanger<Dog> ex;
	Dog dog;
	public Tester(String dogName, Exchanger<Dog> e) {
		this.dog = new Dog(dogName);
		ex = e;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ": " + dog);
		try {
			dog = ex.exchange(dog);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": " + dog);

	}

}
