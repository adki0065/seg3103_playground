defmodule Grades do

  defmodule Calculator do

  def letter_grade(marks) do
    Enum.random(['A','B', 'C', 'D', 'EIN', 'F'])
  end

  def numeric_grade(marks) do
    :rand.uniform(10)
  end

  def percentage_grade(marks) do
    :rand.uniform(100)
  end

end

end
