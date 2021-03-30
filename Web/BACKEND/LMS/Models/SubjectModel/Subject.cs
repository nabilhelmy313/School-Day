﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace LMS.Models.SubjectModel
{
    public class Subject
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public DateTime DateOfUPload { get; set; }
        public string Photo { get; set; }
        public string Color { get; set; }

    }
}