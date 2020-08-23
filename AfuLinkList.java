/**
 * 单链表
 * 
 * @author AfuAnthony
 *
 * @param <DATA>数据域类型泛型
 * 
 * @apiNote 如果有元素，则index从0开始。
 * 初始化时，size为0，只包含一个head节点。
 * 
 */
public class AfuLinkList<DATA> {
	private Node mHead;
    private	int mSize;

	public AfuLinkList() {
		mHead = new Node();
		mSize = 0;
	}


	public boolean add(DATA data) {
		Node newNode = new Node(data);
		Node lastNode = getNode(getSize()-1);
		if(lastNode!=null) {
			lastNode.next=newNode;
			mSize++;
			return true;
		}
		return false;
	}

	public boolean  delete() {
		if(mSize==0) {
			return false;
		}
		Node lastSecondNode;
		lastSecondNode = getNode(getSize()-1);
		if(lastSecondNode!=null) {
			lastSecondNode.next=null;
			mSize--;
			return true;
		}
		return false;
		
	}
	
	public boolean insert(int index, DATA data) {
		Node newNode = new Node(data);
		if(index>=0&&index<getSize()) {
			Node insertPreNode = getNode(index-1);
			if(insertPreNode!=null) {
			Node insertPositionNode = 	insertPreNode.next;
				if(insertPositionNode!=null) {
					insertPreNode.next=newNode;
					newNode.next=insertPositionNode;
					mSize++;
					return true;
				}
			}
		}
		return false;
	}

	public boolean modify(int index, DATA data) {
		if(index>=0&&index<getSize()) {
			Node node = getNode(index);
			if(node!=null) {
				node.setData(data);
				return true;
			}
		}
		return false;
	}

	public Node getNode(int index) {
		if(index==-1) {
			return mHead;
		}else if(index>-1&&index<mSize) {
			Node tmpNode = mHead;
			for(int i=0;i<=index;i++) {
				tmpNode = tmpNode.next;
			}
			return tmpNode;
		}
		return null;
	}

	public int getSize() {
		return mSize;
	}
	
	
	public boolean isEmpty(){
		return mSize==0;
	}
	
	@Override
	public String toString() {
		int listSize = mSize;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("size=")
		.append(listSize)
		.append("\r\n");
		if(!isEmpty()) {
			Node tmpNode = mHead;
			for(int index=0;index<listSize;index++) {
				tmpNode = tmpNode.next;
				stringBuilder.append('[')
				.append(index)
				.append(']')
				.append("=")
				.append(tmpNode.getData())
				.append("\r\n");
			}
		}
		return stringBuilder.toString();
	}

	public void print() {
		System.out.println(toString());
	}
	
	public class Node {
		private DATA data;
		private Node next;

		public Node() {
		}

		public Node(DATA data, AfuLinkList<DATA>.Node next) {
			super();
			this.data = data;
			this.next = next;
		}

		public Node(DATA data) {
			super();
			this.data = data;
		}

		public Node(AfuLinkList<DATA>.Node next) {
			super();
			this.next = next;
		}

		public DATA getData() {
			return data;
		}

		public void setData(DATA data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		AfuLinkList<Integer> linkList = new AfuLinkList<>();
		System.out.println(linkList.add(3));
		System.out.println(linkList.add(2));
		linkList.add(1);
		linkList.insert(2, 0);
		linkList.print();
		linkList.delete();
		linkList.print();
		linkList.modify(2, 1);
		linkList.print();
	}

}
