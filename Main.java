
import java.util.*;
import java.io.*;
class Books
{
    ArrayList<String> name=new ArrayList<String>();
    ArrayList<String> A_name=new ArrayList<String>();
    ArrayList<Integer> id=new ArrayList<Integer>();
    ArrayList<Integer> prc=new ArrayList<Integer>();
    ArrayList<Integer> iss=new ArrayList<Integer>();
    
}
class Student
{
    ArrayList<String> s_name=new ArrayList<String>();
    ArrayList<Integer> s_id=new ArrayList<Integer>();
    ArrayList<Integer> s_pwd=new ArrayList<Integer>();
}
class Module
{
	public static void main(String[] args) 
	{
		boolean f=true,m=false;
		String sid="";//sid->Staff Id
		int n,spw,bk_c=0,i,j;//c->Book count,spw->Staff Password,n->Main Menu Options,i&j->Iterators
		Books bk=new Books();
		Student std=new Student();
		int std_c=0;
		while(f)
		{
		    Scanner sc=new Scanner(System.in);
		    System.out.print("1.Staff\n2.Student\n3.Exit\n");
		    n=sc.nextInt();
		    if(n==1)
		    {
		        System.out.print("Enter Staff Id:");
		        sid=sc.next();
		        System.out.print("Enter Password:");
		        spw=sc.nextInt();
		        if(sid.equalsIgnoreCase("TEQ")&&spw==123)
		        {
		           System.out.print("Login Successful\n");
		           int staff_opt=5;
		           while(staff_opt!=0){
		           if(staff_opt==5)
		           {    System.out.print("1.Add Books\n2.View Issued Books\n3.Report\n4.Logout\n");
		                staff_opt=sc.nextInt();
		           }
		           if(staff_opt==1)
		           {
		              System.out.print("Enter No.Of Books to Add:");
		              j=sc.nextInt();
		              for(i=0;i<j;i++)
		              {
		                bk.id.add(100+bk_c); 
		                System.out.print("Enter Book Name:");
		                bk.name.add(sc.next());
		                System.out.print("Enter Author name:");
		                bk.A_name.add(sc.next());
		                System.out.print("Enter Book Price:");
		                bk.prc.add(sc.nextInt());
		                bk.iss.add(0);
		                bk_c++;
		              }
		           }
		           else if(staff_opt==2)
		           {	System.out.print("Book_ID\tBook_Name\tAuthor_Name\tPrice\n");
		               for(i=0,j=0;i<bk_c;i++)
		               {		                   
		                   if(bk.iss.get(i)==1)
		                   {
		                       j++;
		                       System.out.print(bk.id.get(i)+"\t\t"+bk.name.get(i)+"\t\t"+bk.A_name.get(i)+"\t\t"+bk.prc.get(i)+"\n");
		                   }
		               }
		               if(j==0)
		                   System.out.print("No Books Issued!!!\n");
		            }
		            else if(staff_opt==3) 
		            {
		                System.out.print("Report created!!!\n");
		                try 
		                {
		                    File myObj = new File("Report.txt");
		                    if (myObj.createNewFile())
		                    {
		                        System.out.println("File created: " + myObj.getName());
		                    } 
		                    else 
		                    {
		                        System.out.println("File already exists.");
		                        
		                    }
		                    
		                } 
		                catch (IOException e) 
		                {
		                    System.out.println("An error occurred.");
		                    e.printStackTrace();
		                }
		                try
		                {
		                    FileWriter rep= new FileWriter("Report.txt");
		                    rep.write("Book_ID\tBook_Name\tAuthor_Name\tPrice\tBook Available\n");
		                    for(i=0;i<bk_c;i++)
		                    {
		                        rep.write(bk.id.get(i)+"\t\t"+bk.name.get(i)+"\t\t"+bk.A_name.get(i)+"\t\t"+bk.prc.get(i)+"\t\t");
		                        if(bk.iss.get(i)==1)
		                            rep.write("No\n");
		                        else
		                            rep.write("Yes\n");
		                    }
		                    rep.close();
		                }
		                catch(IOException e)
		                {
		                    System.out.print("An Error Occured\n");
		                }
		            }
		            else if(staff_opt==4) 
		            {
		                System.out.print("Logged Out!!!\n");
		                break;
		            }
		            else 
		            {
		               System.out.print("Invalid Input!!!\n"); 
		            }
		            staff_opt=5;
		           } 
		        }
		        else
		        {
		            System.out.print("Invalid Id/Password\n");
		        }
		    }
		    else if(n==2)
		    {
		        int stud_opt=5;
		        while(stud_opt!=0){
		        if(stud_opt==5)
		        {   System.out.print("1.SignUp\n2.SignIn\n3.Exit\n"); 
		            stud_opt=sc.nextInt();
		        }      
		        if(stud_opt==1)
		        {
		            System.out.print("Enter Student Name:");
		            std.s_name.add(sc.next());
		            System.out.print("Enter Password:");
		            std.s_pwd.add(sc.nextInt());
		            std.s_id.add(100+std_c);
		            System.out.print("Your Student ID is:"+(100+std_c)+"\n");
		            std_c++;
		        }
		        else if(stud_opt==2)
		        {
		            System.out.print("Enter Student ID:");
		            int stud_id=sc.nextInt();
		            System.out.print("Enter Student Password:");
		            int stud_pwd=sc.nextInt();
		            for(i=0;i<std_c;i++)
		            {
		                if(std.s_id.get(i)==stud_id&&std.s_pwd.get(i)==stud_pwd)
		                {
		                    System.out.print("Student Login Successful...\n");
		                    int bk_opt=5;
		                    while(bk_opt!=0){
		                    if(bk_opt==5)
		                    {   System.out.print("1.View Available Book\n2.Borrow Book\n3.Return Book\n4.Logout\n");
		                        bk_opt=sc.nextInt();
		                    }
		                    if(bk_opt==1)
		                    {   System.out.print("Book Id\tBook Name\tAuthor Name\tBook Price\n");
		                        for(i=0;i<bk_c;i++)
		                        {
		                            if(bk.iss.get(i)==0)
		                            System.out.print(bk.id.get(i)+"\t\t"+bk.name.get(i)+"\t\t"+bk.A_name.get(i)+"\t\t"+bk.prc.get(i)+"\n");
		                        }
		                    }
		                    else if(bk_opt==2)
		                    {
		                        System.out.print("Enter Borrowing Book ID:");
		                        int bk_id=sc.nextInt();
		                        m=true;
		                        for(i=0;i<bk_c;i++)
		                        {
		                            if(bk.id.get(i)==bk_id&&bk.iss.get(i)==0)
		                            {
		                                bk.iss.set(i,1);
		                                m=false;
		                                System.out.print("Book Borrowed Successfully...\n");
		                            }		                            
		                        }
		                        if(m)
		                        {
		                            System.out.print("Invalid Book Id!!!\n");
		                            continue;
		                        }
		                    }
		                    else if(bk_opt==3)
		                    {
		                        System.out.print("Enter Returning Book ID:");
		                        int bk_id=sc.nextInt();
		                        m=true;
		                        for(i=0;i<bk_c;i++)
		                        {
		                            if(bk.id.get(i)==bk_id&&bk.iss.get(i)==1)
		                            {
		                                bk.iss.set(i,0);
		                                m=false;
		                                System.out.print("Book Returned Successfully...\n");
		                            }		                            
		                        }
		                        if(m)
		                        {
		                            System.out.print("Invalid Book Id!!!\n");
		                            break;
		                        }
		                    }
		                    else if(bk_opt==4)
		                    {
		                        System.out.print("Student Logout Successful...\n");
		                        break;
		                        
		                    }
		                    else
		                    {
		                        System.out.print("Invalid Input!!!\n");
		                        
		                    }
		                    bk_opt=5;
		                }
		               }
		            }
		        }
		        else if(stud_opt==3)
		        {
		            System.out.print("Exiting to Main Menu!!!\n");
		            break;
		        }
		        else
		        {   System.out.print("Invalid Input!!!\n");
		           
		        }
		        stud_opt=5;
		       } 
		    }
		    else if(n==3)
		    {    
		        System.exit(0);
		    }
		    else
		    {
		        System.out.print("Invalid Input!!!\n");
		        continue;
		    }
		}
	}
}


