class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> answer = new ArrayList<>();
      Queue<Node> q = new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()){
          int size = q.size();
          Boolean set = false;
          for(int i = 0; i < size; i++){
               Node curr = q.poll();
               if(set == false) {
                   answer.add(curr.data);
                   set = true;
               }
               if(curr.left != null) q.add(curr.left);
               if(curr.right != null) q.add(curr.right);
          }
      }
      
      return answer;
    }
}
