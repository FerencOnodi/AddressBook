import java.util.Comparator;

/**
 * Created by ferenc on 2017.02.23..
 */
public class Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public Person(String firstName, String lastName, String address, String city, String state, String zip, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    // The following comparators should go inside class Person:


    /** Comparator for comparing two persons by alphabetical order of name
     */
    public static class CompareByName implements Comparator
    {
        /** Compare two objects (which must both be Persons) by last name,
         *	with ties broken by first name
         *
         *	@param person1 the first object
         *	@param person2 the second object
         *	@return a negative number if person1 belongs before person2 in
         *			alphabetical order of name; 0 if they are equal; a
         *			positive number if person1 belongs after person2
         *
         *	@exception ClassCastException if either parameter is not a
         *			   Person object
         */
        public int compare(Object person1, Object person2)
        {
            int compareByLast = ((Person) person1).getLastName().compareTo(
                    ((Person) person2).getLastName());
            if (compareByLast != 0)
                return compareByLast;
            else
                return ((Person) person1).getFirstName().compareTo(
                        ((Person) person2).getFirstName());
        }

        /** Compare two objects (which must both be Persons) by name
         *
         *	@param person1 the first object
         *	@param person2 the second object
         *	@return true if they have the same name, false if they do not
         *
         *	@exception ClassCastException if either parameter is not a
         *			   Person object
         */
        public boolean equals(Object person1, Object person2)
        {
            return compare(person1, person2) == 0;
        }
    }

    /** Comparator for comparing two persons by order of zip code
     */
    public static class CompareByZip implements Comparator
    {
        /** Compare two objects (which must both be Persons) by zip
         *
         *	@param person1 the first object
         *	@param person2 the second object
         *	@return a negative number if person1 belongs before person2 in
         *			order of zip; 0 if they are equal; a positive number if
         *		    person1 belongs after person2
         *
         *	@exception ClassCastException if either parameter is not a
         *			   Person object
         */
        public int compare(Object person1, Object person2)
        {
            int compareByZip = ((Person) person1).getZip().compareTo(
                    ((Person) person2).getZip());
            if (compareByZip != 0)
                return compareByZip;
            else
                return new CompareByName().compare(person1, person2);
        }

        /** Compare two objects (which must both be Persons) by zip
         *
         *	@param person1 the first object
         *	@param person2 the second object
         *	@return true if they have the same zip, false if they do not
         *
         *	@exception ClassCastException if either parameter is not a
         *			   Person object
         */
        public boolean equals(Object person1, Object person2)
        {
            return compare(person1, person2) == 0;
        }
    }





}


