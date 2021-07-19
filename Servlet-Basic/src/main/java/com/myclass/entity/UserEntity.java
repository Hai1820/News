package com.myclass.entity;




public class UserEntity extends AbstractEntity<UserEntity> {
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleId;
	private RoleEntity role = new RoleEntity();
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public RoleEntity getRole() {
		return role;
	}
	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
}
