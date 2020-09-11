package com.learnbay.ds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.learnbay.HeapGeneric;

import java.util.Queue;

public class Graph {

	private class Vertex{
		Map<String, Integer> nbrs = new HashMap<>();
	}

	Map<String, Vertex> vertices = new HashMap<>();

	public int numVertex() {
		return this.vertices.keySet().size();
	}

	public boolean containsVertex(String val) {
		return this.vertices.containsKey(val);
	}

	public void addVertex(String vName) {
		Vertex v = new Vertex();
		this.vertices.put(vName,v);
	}

	public void removeVertex(String vName) {
		Vertex vt = vertices.get(vName);
		Set<String> set = vertices.keySet();

		for(String s :set) {
			Vertex nbrVtx = vertices.get(vName);
			nbrVtx.nbrs.remove(vName);
		}
		vertices.remove(vName);
	}

	public int numEdges() {
		Set<Entry<String, Vertex>> entries = this.vertices.entrySet();
		return entries.stream().collect(Collectors.summingInt(entry -> entry.getValue().nbrs.size()));
	}

	public boolean containsEdge(String vName1, String vName2) {
		Vertex v1 = vertices.get(vName1);
		Vertex v2 = vertices.get(vName2);
		boolean result =true;

		if(v1== null || v2 == null || !v1.nbrs.containsKey(vName2)) {
			result = false;
		}

		return result;
	}

	public void addEdge(String vName1, String vName2, int cost) {
		if(containsEdge(vName1,vName2)) {
			return;
		}
		Vertex v1 = vertices.get(vName1);
		Vertex v2 = vertices.get(vName2);

		v1.nbrs.put(vName2, cost);
		v2.nbrs.put(vName1, cost);

	}

	public void removeEdge(String vName1, String vName2) {
		if(!containsEdge(vName1,vName2)) {
			return;
		}
		Vertex v1 = vertices.get(vName1);
		Vertex v2 = vertices.get(vName2);

		v1.nbrs.remove(vName2);
		v2.nbrs.remove(vName1);
	}

	public void display() {
		Set<String> vSet = vertices.keySet();
		for(String key: vSet) {
			System.out.println(vertices.get(key).nbrs);
		}
	}

	public boolean hasPath(String vName1, String vName2, List<String> processed) {

		if(containsEdge(vName1,vName2)) {
			return true;
		}
		processed.add(vName1);
		Set<String> vertMembers = vertices.keySet();
		for(String vertMember :vertMembers) {
			if(!processed.contains(vertMember) && hasPath(vertMember,vName2,processed)) {
				return true;
			}
			processed.add(vertMember);
		}

		return false;
	}

	private class Pair{
		String vname;
		String psf;
	}

	private class PrimsPair implements Comparable<PrimsPair>{
		String vname;
		String acqvname;
		int cost;

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost- this.cost;
		}
	}

	private class DijkstraPair implements Comparable<DijkstraPair>{
		String vname;
		String psf;
		int cost;

		@Override
		public int compareTo(DijkstraPair o) {
			return o.cost- this.cost;
		}
	}

	public boolean bfs(String src, String dst) {

		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname =src;
		sp.psf =src;

		q.addLast(sp);

		while(!q.isEmpty()) {
			Pair rp = q.removeFirst();

			if(processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			if(containsEdge(rp.vname,dst)) {
				return true;
			}

			Vertex rpvertex  = vertices.get(rp.vname);
			Set<String> nbrs = rpvertex.nbrs.keySet();

			for(String nbr :nbrs) {
				if(!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf +nbr;

					q.addLast(np);
				}
			}
		}
		return false;
	}

	public void bft(String src, String dst) {

		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		Set<String> keys = vertices.keySet();

		for (String key:keys) {

			if(processed.containsKey(key)) {continue;}

			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			q.addLast(sp);
			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + "	" + rp.psf);

				Vertex rpvertex = vertices.get(rp.vname);
				Set<String> nbrs = rpvertex.nbrs.keySet();

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						q.addLast(np);
					}
				}
			} 
		}
	}

	public boolean dfs(String src, String dst) {

		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();

		Pair sp = new Pair();
		sp.vname =src;
		sp.psf =src;

		stack.addFirst(sp);

		while(!stack.isEmpty()) {
			Pair rp = stack.removeFirst();

			if(processed.containsKey(rp.vname)) {
				continue;
			}

			processed.put(rp.vname, true);

			if(containsEdge(rp.vname,dst)) {
				return true;
			}

			Vertex rpvertex  = vertices.get(rp.vname);
			Set<String> nbrs = rpvertex.nbrs.keySet();

			for(String nbr :nbrs) {
				if(!processed.containsKey(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf +nbr;

					stack.addFirst(np);
				}
			}
		}
		return false;
	}

	public void dft(String src, String dst) {

		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> stack = new LinkedList<>();
		Set<String> keys = vertices.keySet();

		for (String key:keys) {

			if(processed.containsKey(key)) {continue;}

			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			stack.addFirst(sp);
			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + "	" + rp.psf);

				Vertex rpvertex = vertices.get(rp.vname);
				Set<String> nbrs = rpvertex.nbrs.keySet();

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						stack.addFirst(np);
					}
				}
			} 
		}
	}

	public boolean isCyclic() {

		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		Set<String> keys = vertices.keySet();

		for (String key:keys) {

			if(processed.containsKey(key)) {continue;}

			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			q.addLast(sp);
			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + "	" + rp.psf);

				Vertex rpvertex = vertices.get(rp.vname);
				Set<String> nbrs = rpvertex.nbrs.keySet();

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						q.addLast(np);
					}
				}
			} 
		}
		return false;
	}

	public boolean isConnected() {
		int flag = 0;
		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		Set<String> keys = vertices.keySet();

		for (String key:keys) {

			if(processed.containsKey(key)) {continue;}

			flag++;

			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			q.addLast(sp);
			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				System.out.println(rp.vname + "	" + rp.psf);

				Vertex rpvertex = vertices.get(rp.vname);
				Set<String> nbrs = rpvertex.nbrs.keySet();

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						q.addLast(np);
					}
				}
			} 
		}
		return (flag< 2);
	}

	public boolean isTree() {
		/* Tree always has n-1 edges*/
		return !isCyclic() && isConnected();
	}

	public List<List<String>> getConnected(String src, String dst) {

		List<List<String>> finalAns = new ArrayList<>();
		/* Level Order traversal */
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		Set<String> keys = vertices.keySet();

		for (String key:keys) {

			if(processed.containsKey(key)) {continue;}

			List<String> subAns = new ArrayList<>();

			Pair sp = new Pair();
			sp.vname = key;
			sp.psf = key;
			q.addLast(sp);
			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}

				processed.put(rp.vname, true);

				subAns.add(rp.vname);

				Vertex rpvertex = vertices.get(rp.vname);
				Set<String> nbrs = rpvertex.nbrs.keySet();

				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;

						q.addLast(np);
					}
				}
			} 
			finalAns.add(subAns);
		}
		return finalAns;
	}

	public Graph prims() {
		Graph mst = new Graph();
		Map<String, PrimsPair> map = new HashMap<>();
		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

		// Make a pair and put in heap and map
		for(String key:vertices.keySet()) {
			PrimsPair np = new PrimsPair();
			np.vname = key;
			np.acqvname = null;
			np.cost =Integer.MAX_VALUE;

			heap.add(np);
			map.put(key, np);

		}

		while(heap.isEmpty()==false) {

			//remove from top of min heap
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);

			// add to mst
			if(rp.vname==null) {
				mst.addVertex(rp.vname);
			}else {
				mst.addVertex(rp.vname);
				mst.addEdge(rp.vname, rp.acqvname, rp.cost);
			}

			//nbrs
			for(String nbr: vertices.get(rp.vname).nbrs.keySet()) {
				// work for nbrs in heap
				if(map.containsKey(nbr)) {
					// get old cost and compare with new cost

					int oc = map.get(nbr).cost;
					int nc = vertices.get(rp.vname).nbrs.get(nbr);
					//Update the pair if new cost is lower
					if(nc < oc) {
						PrimsPair gp = map.get(nbr);
						gp.acqvname = rp.vname;
						gp.cost = nc;

						heap.updatePriority(gp);
					}
				}

			}

		}
		return mst;
	}

	public Map<String, Integer> dijkstra(String src){
		Map<String, Integer> ans = new HashMap<>();
		Map<String,  DijkstraPair> map = new HashMap<>();
		HeapGeneric< DijkstraPair> heap = new HeapGeneric<>();

		// Make a pair and put in heap and map
		for(String key:vertices.keySet()) {
			DijkstraPair np = new DijkstraPair();
			np.vname = key;
			np.psf = null;
			np.cost = Integer.MAX_VALUE;
			if(key.equals(src)) {
				np.cost = 0;
				np.psf = key;
			}
			heap.add(np);
			map.put(key, np);

		}

		while(heap.isEmpty()==false) {

			//remove from top of min heap
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);
			
			// add to ans
			ans.put(rp.vname, rp.cost);

			//nbrs
			for(String nbr: vertices.get(rp.vname).nbrs.keySet()) {
				// work for nbrs in heap
				if(map.containsKey(nbr)) {
					// get old cost and compare with new cost

					int oc = map.get(nbr).cost;
					int nc = rp.cost + vertices.get(rp.vname).nbrs.get(nbr);
					//Update the pair if new cost is lower
					if(nc < oc) {
						DijkstraPair gp = map.get(nbr);
						gp.psf = rp.psf + rp.vname;
						gp.cost = nc;

						heap.updatePriority(gp);
					}
				}

			}

		}
		return ans;
	}



}
