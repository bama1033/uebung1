/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auto;

/**
 *
 * @author Martin
 */
public class Task implements Comparable<Task>  {
	public String name;
	public int compute;
        public int computeOrig;
	public int period;
        public int periodOrig;
	public int deadline;
	
	public Task(String name,int compute, int period, int deadline) {
            this.name =name;
            this.compute = compute;
            this.computeOrig =compute;
            this.period = period;
            this.periodOrig = period;
            this.deadline = deadline;
	}
	//TODO if deadline empty...
	public String getName() {
		return name;
	}
        public int getCompute() {
		return compute;
	}
        public int getComputeOrig() {
		return computeOrig;
	}
        public int getPeriod() {
		return period;
	}
        public int getPeriodOrig() {
		return periodOrig;
	}       
        public int getDeadline() {
		return deadline;
	}
        public void setPeriod(int i){
            if(i==-1){
                return;
            }
                else this.period = i;
        }
        public void setCompute(int i){
            this.compute = i;
        }


    @Override
    public int compareTo(Task task) {
        if(this.getPeriod()>task.getPeriod()){
            return 1;
        } else if (this.getPeriod()<task.getPeriod()){
            return -1;
    }
    return 0; 
    }
}