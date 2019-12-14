package com.person.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Entity for inserting into database
 * Set is like it is done in Hibernate
 */

@Entity
@Table(name = "mvc_person_details")
public class PersonsEntity {

    /* Since the name of the fields are same as that of the database column names
     * Explicit @Column need not be given. For an illustration, image array is given */
	
	private int UID;
    private String email;
    private String password;
    private String dob;
    private String tob;
    private String country;
    private String ethinicity;
	private String isHappy;
    private byte[] image;

    // For creating a new Object in the IPersonService
    public PersonsEntity() {

    }

    // Name Constructor
    public PersonsEntity(String email, String password, String dob, String tob, String country, String ethnicity, String isHappy, byte[] image) {
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.tob = tob;
        this.country = country;
        this.ethinicity = ethnicity;
        this.isHappy = isHappy;
        this.image = image;
    }

    @Override
    public String toString() {
        String ret = "From PersonsDataEntiry : [email: " + email +
                ", password: " + password + ", Date Of Birth: " + dob + ", Time of Birth: " +
                tob + ", Country: " + country + ", ethnicity: " + ethinicity + ", isHappy? " + isHappy;

        return ret;
    }
    // ACCESSORS AND MUTATORS
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}
    public String getEmail() {
 		return email;
 	}

 	public void setEmail(String email) {
 		this.email = email;
 	}

 	public String getPassword() {
 		return password;
 	}

 	public void setPassword(String password) {
 		this.password = password;
 	}

 	public String getDob() {
 		return dob;
 	}

 	public void setDob(String dob) {
 		this.dob = dob;
 	}

 	public String getTob() {
 		return tob;
 	}

 	public void setTob(String tob) {
 		this.tob = tob;
 	}

 	public String getCountry() {
 		return country;
 	}

 	public void setCountry(String country) {
 		this.country = country;
 	}

 	public String getEthinicity() {
 		return ethinicity;
 	}

 	public void setEthinicity(String ethinicity) {
 		this.ethinicity = ethinicity;
 	}

 	public String getIsHappy() {
 		return isHappy;
 	}

 	public void setIsHappy(String isHappy) {
 		this.isHappy = isHappy;
 	}

 	@Column(columnDefinition = "longblob", name = "image")
 	public byte[] getImage() {
 		return image;
 	}

 	public void setImage(byte[] image) {
 		this.image = image;
 	}
}
