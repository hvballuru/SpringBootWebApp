package com.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class StarterOne {
	@Autowired
	private qaRepository qarepository;
	@Autowired
	private mwRepository mwrepository;
	@Autowired
	private webRepository webrepository;
	@Autowired
	private cmtRepository cmtrepository;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StarterOne.class, args);
	}

	@RequestMapping("/qa")
	public List<qa> home() {

		List<qa> qa = this.qarepository.findAll();
		/*
		 * Set<qa> ls = new HashSet<>();
		 * 
		 * for(int i=0; i<qa.size();i++){ ls.add(qa.get(i)); }
		 */
		return qa;

	}

	@RequestMapping("/mw")
	public List<mw> retmw() {
		List<mw> mw = this.mwrepository.findAll();
		return mw;
	}

	@RequestMapping("/web")
	public List<web> retweb() {
		List<web> web = this.webrepository.findAll();
		return web;
	}

	@RequestMapping("/cmt")
	public List<cmt> retcmt() {
		List<cmt> cmt = this.cmtrepository.findAll();
		return cmt;
	}

	@RequestMapping("/rip")
	public String retIP() {
		InetAddress ipa=null;
		try {
			ipa = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if(ipa==null){
			return "Unable to retrieve remote address";
		}
		else
			return "remote address: " + ipa.toString();
	}

	@RequestMapping("/")
	public String methodOne() {
		return "Hi from Spring Boot";
	}
}

@Repository
interface qaRepository extends JpaRepository<qa, String> {
}

@Repository
interface mwRepository extends JpaRepository<mw, String> {
}

@Repository
interface webRepository extends JpaRepository<web, String> {
}

@Repository
interface cmtRepository extends JpaRepository<cmt, String> {
}

@Entity
class qa {
	@Id
	@GeneratedValue
	private String name;
	private String vendor;
	private String license;
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "qa [name=" + name + ", vendor=" + vendor + ", license=" + license + ", rank=" + rank + "]";
	}
}

@Entity
class mw {
	@Id
	@GeneratedValue
	private String name;
	private String vendor;
	private String license;
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

@Entity
class web {
	@Id
	@GeneratedValue
	private String name;
	private String vendor;
	private String license;
	private String share;
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}

@Entity
class cmt {
	@Id
	@GeneratedValue
	private String name;
	private String writtenin;
	private String license;
	private int rank;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWrittenin() {
		return writtenin;
	}

	public void setWrittenin(String writtenin) {
		this.writtenin = writtenin;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
