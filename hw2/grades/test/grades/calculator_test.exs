ExUnit.start()

defmodule Grades.CalculatorTest do
  use ExUnit.Case
  alias Grades.Calculator

  describe "grades_branch_coverage" do
    test "tc_1_zeroes" do
      assert 0 ==
               Calculator.percentage_grade(%{
                 homework: [0,0],
                 labs: [0, 0, 0],
                 midterm: 0,
                 final: 0
               })
      assert "EIN" ==
                Calculator.letter_grade(%{
                  homework: [0,0],
                  labs: [0, 0, 0],
                  midterm: 0,
                  final: 0
                })

      assert 0 ==
                Calculator.numeric_grade(%{
                  homework: [0,0],
                  labs: [0, 0, 0],
                  midterm: 0,
                  final: 0
                })


  end
  test "tc_2_perfect" do
    assert 100 ==
             Calculator.percentage_grade(%{
               homework: [1,1],
               labs: [1, 1, 1],
               midterm: 1,
               final: 1
             })
    assert "A+" ==
              Calculator.letter_grade(%{
                homework: [1,1],
                labs: [1, 1, 1],
                midterm: 1,
                final: 1
              })
    assert 10 ==
                Calculator.numeric_grade(%{
                  homework: [1,1],
                  labs: [1, 1, 1],
                  midterm: 1,
                  final: 1
                })


  end
  test "tc_3_fail" do
    assert 38 ==
             Calculator.percentage_grade(%{
               homework: [0.4, 0.4],
               labs: [0.3, 0.3, 0.30],
               midterm: 0.4,
               final: 0.4
             })
    assert "F" ==
              Calculator.letter_grade(%{
                homework: [0.4, 0.4],
                labs: [0.3, 0.3, 0.30],
                midterm: 0.4,
                final: 0.4
              })
    assert 0 ==
                Calculator.numeric_grade(%{
                  homework: [0.4, 0.4],
                  labs: [0.3, 0.3, 0.30],
                  midterm: 0.4,
                  final: 0.4
                })
  end
end
end
