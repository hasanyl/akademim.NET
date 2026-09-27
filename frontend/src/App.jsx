import { useState, useEffect } from 'react'

function App() {

    const [courses, setCourses ] = useState([]);
    const [courseName, setCourseName] = useState("");
    const [courseTeacher, setCourseTeacher] = useState("");
    const [editingCourseId, setEditingCourseId] = useState(null);

  useEffect(() => {
    getCourses()
  }, []);

  async function getCourses(){
    const response = await fetch("http://localhost:8080/api/courses");
    const data = await response.json();

    setCourses(data);
  }

  async function addCourse(){
      //Validation
      if(!courseName.trim() || !courseTeacher.trim()){
          alert("Ders adı ve ders hocası boş bırakılamaz!");
          return;
      }

    const course = {
      courseName,
      courseTeacher
    }

    await fetch("http://localhost:8080/api/courses", {
      method : "POST",
      headers : {
        "Content-Type" : "application/json"
      },
      body : JSON.stringify(course)
    });

    await getCourses();
  }

  async function deleteCourse(courseId){
      const response = await fetch("http://localhost:8080/api/courses/" + courseId, {
          method : "DELETE"
      });

      console.log("Silme işlemi cevabı : " + response.status);

      await getCourses();
  }

  function editCourse(course){
      setEditingCourseId(course.courseId);
      setCourseName(course.courseName);
      setCourseTeacher(course.courseTeacher);
  }

  async function updateCourse(){
      const updatedCourse = {
          courseName,
          courseTeacher,
      };

      const response = await fetch("http://localhost:8080/api/courses/" + editingCourseId,
          {
              method : "PUT",
              headers: {
                  "Content-Type" : "application/json"
              },
              body : JSON.stringify(updatedCourse)
          });

      if(response.ok){
          await getCourses();
          setEditingCourseId(null);
          setCourseName("");
          setCourseTeacher("");
      }
    }

  return (
    <>

      <label>Ders Adı : </label>
      <input
      value={courseName}
      onChange={(event) => setCourseName(event.target.value)}
      />

      <label>Ders Hocası : </label>
      <input
      value={courseTeacher}
      onChange={(event) => setCourseTeacher(event.target.value)}
      />

      <button onClick={editingCourseId === null ? addCourse : updateCourse}>
          {editingCourseId === null ? "Ders Ekle" : "Dersi Güncelle"}
      </button>
        <table>
            <thead>
            <tr>
                <th>
                    Ders Adı
                </th>
                <th>
                    Ders Öğretmeni
                </th>
                <th>
                    İşlemler
                </th>
            </tr>
            </thead>
            <tbody>
            {courses.map(course => (
                <tr key={course.courseId}>
                    <td>{course.courseName}</td>
                    <td>{course.courseTeacher}</td>
                    <td>
                        <button onClick={() => deleteCourse(course.courseId)}>Dersi Sil</button>
                        <button onClick={() => editCourse(course)}>
                            Düzenle
                        </button>
                    </td>

                </tr>
            ))}
            </tbody>
        </table>
    </>
  )
}



export default App
