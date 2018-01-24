
public class S1Final {
	int[] wsum(int[] vals, int[] weights){
		  int[] ans = new int[vals.length];
		  if (vals.length<1) return vals;
		  int find = weights.length/2;
		  for(int i=0;i<vals.length;i++){
		    ans[i]=0;
		    for(int j=0;j<weights.length;j++){
		      ans[i]+=anyWrap(vals,i-find+j)*weights[j];
		    }
		  }
		  return ans;
		}
	int wrapAccess(int[] data, int index){
		  return data[index%data.length];
		}
	int anyWrap(int[] ar, int index){
		  if (ar.length<1) return 0;
		  else return ar[(index%ar.length+ar.length)%ar.length];
		}
	int prev(int[] ar, int index){
		  return anyWrap(ar,index-1);
		}
	int [] sumadjperiodic(int[] ar){
		  int[] ans = new int[ar.length];
		  for(int i=0;i<ans.length;i++){
		    ans[i]=prev(ar,i)+anyWrap(ar,i+1);
		  }
		  return ans;
		}
}
