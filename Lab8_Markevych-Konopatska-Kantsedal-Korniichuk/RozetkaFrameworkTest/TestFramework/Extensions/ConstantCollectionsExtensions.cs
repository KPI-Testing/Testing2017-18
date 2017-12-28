using System.Collections.Generic;

namespace TestFramework.Extensions
{
    public class ConstantCollectionsExtensions
    {
        public static HashSet<char> RussianLetters
        {
            get
            {
                var temp = new HashSet<char>();
                temp.Add('А');
                temp.Add('Б');
                temp.Add('В');
                temp.Add('Г');
                temp.Add('Д');
                temp.Add('Е');
                temp.Add('Ё');
                temp.Add('Ж');
                temp.Add('З');
                temp.Add('И');
                temp.Add('Й');
                temp.Add('К');
                temp.Add('Л');
                temp.Add('М');
                temp.Add('Н');
                temp.Add('О');
                temp.Add('П');
                temp.Add('С');
                temp.Add('Т');
                temp.Add('У');
                temp.Add('Ф');
                temp.Add('Х');
                temp.Add('Ш');
                temp.Add('Щ');
                temp.Add('Ы');
                temp.Add('Э');
                temp.Add('Ю');
                temp.Add('Я');
                return temp;
            }
        }

    }
}
