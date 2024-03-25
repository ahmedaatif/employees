# Employees

REST API project created in Spring boot using Maven, Java 21

## API Reference

#### Create Employee

```http
  POST /employees
```

| Parameter     | Type     | Description                                                            |
| :------------ | :------- | :--------------------------------------------------------------------- |
| `firstName`   | `string` | **Required**. First Name                                               |
| `lastName`    | `string` | **Required**. Last Name                                                |
| `dateOfBirth` | `string` | **Required**. DoB                                                      |
| `salary`      | `string` | **Required**. Salary                                                   |
| `joinDate`    | `string` | **Required**. Join Date                                                |
| `departement` | `string` | **Required**. Note; Typo is included as it was provided in the example |

#### Get Single Employee

```http
  GET /employees/${id}
```

| Parameter | Type  | Description                           |
| :-------- | :---- | :------------------------------------ |
| `id`      | `int` | **Required**. Id of employee to fetch |

#### Get Employees

```http
  GET /employees?name=${name}&fromSalary=${fromSalary}&toSalary=${toSalary}
```

| Parameter    | Type     | Description                                        |
| :----------- | :------- | :------------------------------------------------- |
| `name`       | `string` | **Optional** Searches in both first and last names |
| `fromSalary` | `int`    | **Optional**                                       |
| `toSalary`   | `int`    | **Optional**                                       |
