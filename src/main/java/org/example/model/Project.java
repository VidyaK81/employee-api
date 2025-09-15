package org.example.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name= "Project")
public class Project {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProjectId")
    private int projectId;

    @Column(nullable = false)
    private String projectName;

    @Column(name = "projectStatus")
    private String projectStatus;

    @Column
    private LocalDate projectStartDate;

    public Project(){}

    public Project(int projectId, String projectName, String projectStatus, LocalDate projectStartDate) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.projectStartDate = projectStartDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(LocalDate projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
}
