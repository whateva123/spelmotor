package spelmotorn;

public class Runner implements Runnable{ //denna var tänkt att vara en gameLoop, men eftersom detta är programmerat i Swing han vi inte till den komplexitetsgraden då denna behövdes riktigt. Dvs så kommer vi ditt eventually
	private boolean running = false;
	private Renderare renderer;

	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D/60D;
		long lastTimer = System.currentTimeMillis();
		double sec = 0;
		int frames = 0;
		int ticks = 0;
		while(running){
			long now = System.nanoTime();
			sec += (now - lastTime)/nsPerTick;
			lastTime = now;
			boolean shouldRender = false;
			while(sec >= 1){
				ticks++;
				tick();
				sec -= 1;
				shouldRender = true;
			}
			if(shouldRender){
			
			frames++;
			renderer.repaint();
			}
			if(System.currentTimeMillis() - lastTimer >= 1000){
				System.out.println(ticks + " ticks, " + frames + " frames");
				lastTimer += 1000;
				frames = 0;
				ticks = 0;
			}
		}
	}
	public synchronized void start() {
		running = true;
		new Thread(this).start();
		
	}
	
	public synchronized void stop() {
		running = false;
		
	}
	
	public void tick(){
		
	}
	
	public void addRenderer(Renderare rend){
		renderer = rend;
	}

}
