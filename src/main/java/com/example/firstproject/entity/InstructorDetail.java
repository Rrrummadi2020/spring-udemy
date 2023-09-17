package com.example.firstproject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobbies")
    private String hobbies;

    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    private Instructor instructor;//biderection retriving the associated instuctor for this instructor detail

    public InstructorDetail() {
    }

    public InstructorDetail(String youtubeChannel, String hobbies) {
        this.youtubeChannel = youtubeChannel;
        this.hobbies = hobbies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobbies=" + hobbies + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((youtubeChannel == null) ? 0 : youtubeChannel.hashCode());
        result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InstructorDetail other = (InstructorDetail) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (youtubeChannel == null) {
            if (other.youtubeChannel != null)
                return false;
        } else if (!youtubeChannel.equals(other.youtubeChannel))
            return false;
        if (hobbies == null) {
            if (other.hobbies != null)
                return false;
        } else if (!hobbies.equals(other.hobbies))
            return false;
        return true;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
