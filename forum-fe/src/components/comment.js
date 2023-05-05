const Comment = ({id,content}) => {
    return (<>
        <div className="row">
            <div className="col-md-12 text-right border border-black p-2 m-5">
                <p>
                    {content}
                </p>
            </div>
        </div>
    </>);
}
export default Comment;