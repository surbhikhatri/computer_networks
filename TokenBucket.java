
package cnprac;

class Bucket{
    public int tokens, maxsize;

    Bucket(int max){
            tokens = 0;
            maxsize = max;
    }

    synchronized void addToken(int n){
            if(tokens >= maxsize)
                return;
            tokens += 1;
            System.out.println("Added a token. Total:" + tokens);
    }

    synchronized void sendPacket(int n){
            System.out.println("Packet of size " + n + " arrived");
            if(n > tokens){
                    System.out.println("Packet is non comformant, discarded");
                    int r=n-tokens;
                    System.out.println("sending "+tokens+" frames");
                    tokens=0;
                    System.out.println("remaining "+r+" frames");
                    for(int i=0;i<r;i++){
                        addToken(1);
                    }
                    
                    sendPacket(r);
                    
            }
            else{
                    tokens -= n;
                    System.out.println("Forwarding packet");
            }
    }
}


class AddTokenThread extends Thread{
    Bucket b;
    AddTokenThread(Bucket b){
    this.b = b;
    }
    public void run(){
        while(true){
            b.addToken(1);
            try{
                Thread.sleep(300);
            } catch(Exception e){}
        }
    }
}

class AddPacketThread extends Thread{
    Bucket b;
    AddPacketThread(Bucket b){
	this.b = b;
    }
    public void run(){
        while(true){
            try{
		Thread.sleep(500 + (int) (Math.random()*800));
            }
            catch(Exception e){
            }
            b.sendPacket(1 + (int) (Math.random()*9));
	}
    }
}

class TokenBucket{
    public static void main(String args[]){
	Bucket b = new Bucket(10);
	Thread tokens = new AddTokenThread(b);
	Thread packets = new AddPacketThread(b);
	try{
            tokens.start();
            packets.start();
	}
    catch(Exception e){}
    }
}
