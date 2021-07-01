defmodule Grades.Calculator do
  def percentage_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    round(calculate_grade(avg(labs), avg(homework), midterm, final)*100)
  end

  def letter_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
      if failed_to_participate(avg_homework,midterm, final, lab_count(labs) ) do "EIN"
      else mark = calculate_grade(avg(labs), avg_homework, midterm, final)

      cond do
        mark > 0.895 -> "A+"
        mark > 0.845 -> "A"
        mark > 0.795 -> "A-"
        mark > 0.745 -> "B+"
        mark > 0.695 -> "B"
        mark > 0.645 -> "C+"
        mark > 0.595 -> "C"
        mark > 0.545 -> "D+"
        mark > 0.495 -> "D"
        mark > 0.395 -> "E"
        :else -> "F"
      end
    end
  end

  def numeric_grade(%{homework: homework, labs: labs, midterm: midterm, final: final}) do
    avg_homework = avg(homework)
    if failed_to_participate(avg_homework, midterm, final, lab_count(labs) ) do 0
    else mark = calculate_grade(avg(labs), avg_homework, midterm, final)

      cond do
        mark > 0.895 -> 10
        mark > 0.845 -> 9
        mark > 0.795 -> 8
        mark > 0.745 -> 7
        mark > 0.695 -> 6
        mark > 0.645 -> 5
        mark > 0.595 -> 4
        mark > 0.545 -> 3
        mark > 0.495 -> 2
        mark > 0.395 -> 1
        :else -> 0
      end
    end
  end

  def avg(arr) do
      if Enum.count(arr) == 0 do 0
      else Enum.sum(arr) / Enum.count(arr)
      end
end

def failed_to_participate(hw, mid, fin, labs) do
  hw < 0.4 || (mid + fin) / 2 < 0.4 || labs < 3

end
def calculate_grade(labs, hw, mid, fin) do
  0.2 * labs + 0.3 * hw + 0.2 * mid + 0.3 * fin

end
def lab_count(labs)do
  labs
      |> Enum.reject(fn mark -> mark < 0.25 end)
      |> Enum.count()
end
end
end
