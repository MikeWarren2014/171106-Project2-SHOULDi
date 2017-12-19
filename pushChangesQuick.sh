# script for quickly committing changes
# Parameters: 
# • message to commit changes with 
# • (optional) the name of the branch to commit to 

# set this to the name of your branch
DEFAULT_BRANCH=MikesBranch

if [[ $1 == "--help" ]]; then
	echo "This script quickly commits changes to your GitHub repo"
	echo ""
	echo "Parameters : "
	echo "• message to commit changes with"
	echo "• (optional) the name of the branch to commit to"
	echo ""
	echo "If second argument is not specified, this will commit changes to DEFAULT_BRANCH."
	echo ""
	echo "Setup"
	echo "If this script is run under a new project repository, you should change the DEFAULT_BRANCH this script uses"
else

	# pull changes from master
	git pull origin master
	# add everything
	git add .
	# if there was a first parameter passed into this script, use it for the message. Else, just commit
	[[ ! -z "$1" ]] && git commit -m "$1" || git commit
	# if there was a second parameter passed into this script, push to DEFAULT_BRANCH. Else, push to that second parameter
	[[ ! -z "$2" ]] && git push origin $2 || git push origin $DEFAULT_BRANCH
fi
