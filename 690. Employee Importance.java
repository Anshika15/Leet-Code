/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
       HashMap<Integer, Employee> map = new HashMap<>();
    
       for(Employee emp : employees)
       {
           map.put(emp.id, emp);
       }
        
        LinkedList<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        int importance = 0;
        while(q.size() > 0)
        {
            Employee rem = q.removeFirst();
            importance += rem.importance;
            for(int empId : rem.subordinates)
            {
                q.add(map.get(empId));
            }
        }
        return importance;
        
    }
}
