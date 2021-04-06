﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LMS.Models.SubjectModel
{
   public interface ISubjectRepasitory<T>
    {
        void CreateSubject(T subject);
        void UpdateSubject(T subject);
        void DeleteSubject(int Id);
        Task<Subject> Subject(int Id);
        List<Subject> Subjects();

    }
}
