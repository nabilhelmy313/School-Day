﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LMS.Models.PostModel
{
    public class Post
    {
        public int Id { get; set; }
        public string Text { get; set; }
        public DateTime Date { get; set; }
        public string Like { get; set; }
        public StudentModel.Student Student { get; set; }
        public TeacherModel.Teacher Teacher { get; set; }
        public ICollection<CommentModel.Comment> Comments { get; set; }
        public ICollection<PhotoModel.Photo> Photos { get; set; }

    }
}
